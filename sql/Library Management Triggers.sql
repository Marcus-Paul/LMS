USE lms;

-- Trigger to auto update membership expiry
DELIMITER //
create trigger membership_expiry
	before update on members
    for each row
begin 
	-- check if date being updated
    IF NEW.membership_start <> OLD.membership_start THEN
		-- updating the membership expiry
		set new.membership_end = date_add(new.membership_start, interval 6 month);
	end if;
end //

DELIMITER ;

-- triggger to reserved books
DELIMITER //
	create trigger available_copies_update
    before Insert on reservation
    for each row
begin
	if new.current_status = 'Reserved' and (select available_copies from books where book_id = new.book_id) > 0 and not exists (select 1 from reservation where membership_id = new.membership_id and book_id = new.book_id) then
		-- updating the table
        update books
        set available_copies = available_copies - 1
        where book_id = new.book_id;
	elseif exists (select 1 from reservation where membership_id = new.membership_id and book_id = new.book_id) then
		signal sqlstate '45000' set message_text = 'Book Already reserved'; 
	else
		signal sqlstate '45000' set message_text = 'No Available Copies for that book'; 
	end if;
end //

DELIMITER ;

-- trigger to handel canceled reservations
DELIMITER //
create trigger Cancel_update
	after update on reservation
    for each row
begin
	-- When Reservation is canceled
	if new.`current_status` = 'Canceled' and old.`current_status` != 'Canceled' then
		update books
        set available_copies = available_copies + 1
        where book_id = new.book_id;
	end if;
end //
DELIMITER ;


-- trigger to update available copies based on returned transactions
DELIMITER //
create trigger return_update
	after update on transactions
    for each row
begin
	if new.return_date is not null and old.return_date is null then
		update books
        set available_copies = available_copies + 1
        where book_id = new.book_id;
	end if;

end//
DELIMITER ;

-- trigger to update available copies based on transactions
DELIMITER //
create trigger trasaction_available_updates
	before insert on transactions
    for each row
begin
	if not exists (select 1 from transactions where membership_id = new.membership_id and book_id = new.book_id and return_date is null) then
		update books
        set available_copies = available_copies - 1
        where book_id = new.book_id;
	else 
		signal sqlstate '45000' set message_text = 'Book Has Been already issued';
	end if;
end //
DELIMITER ;

-- trigger to insert into transactions table from reservations
DELIMITER //
create trigger transactions_insert
	after update on reservation
    for each row
begin
	if new.current_status = 'Issued' and old.current_status <> 'Issued' then
    insert into transactions (membership_id,book_id) values
		(new.membership_id,new.book_id);
    end if;
end //
DELIMITER ;

-- trigger to update due_date
DELIMITER //
create trigger due_date
	before insert on transactions
    for each row
begin
	if new.due_date is null then
		set new.due_date = (new.issued_date + interval 14 day);
	end if;
end //
DELIMITER ;




