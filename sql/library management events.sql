-- Events
USE lms;
-- Event to update Expired membership
DELIMITER //
CREATE EVENT Expired_membership
ON SCHEDULE EVERY 1 DAY
	DO BEGIN
		UPDATE members
		set isActive = 'Expired'
		where membership_end < current_date();
    end //
DELIMITER ;


-- Event to update Active membership
DELIMITER //
CREATE EVENT Active_membership
ON SCHEDULE EVERY 1 DAY
	DO BEGIN
		UPDATE members
		set isActive = 'Active'
		where membership_end >= current_date();
    end //
DELIMITER ;

-- Event to calculate late fee
DELIMITER //
create event late_event
on schedule every 1 day
	do begin
		update transactions
        set late_fee = datediff(current_date(),due_date) * 2
        where due_date < current_date();
        
    end //
DELIMITER ;





