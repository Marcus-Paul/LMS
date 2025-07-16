drop database if exists  lms;
CREATE DATABASE lms;

USE lms;

-- Creating Books Table
CREATE TABLE books (
	book_id int auto_increment,
    book_name varchar(50),
    author_id int,
    publish_date date,
    total_copies int,
    available_copies int,
    catogery_id int,
    primary key (book_id)
);


-- Creating Authors Table
create table authors (
	author_id int auto_increment,
    first_name varchar(20),
    last_name varchar(20),
    primary key (author_id)
)auto_increment = 200;


-- Creating Catogery Table
create table catogery(
	catogery_id int auto_increment,
    catogery_name varchar(50),
    primary key (catogery_id)
);

alter table catogery auto_increment = 10;

-- Creating Members Table
create table members (
	membership_id int auto_increment,
    first_name varchar(20),
    last_name varchar(20),
    phone varchar(10) check(length(phone)=10),
    membership_start  date default (current_date()),
    membership_end date default (membership_start + INTERVAL 6 MONTH),
    isActive enum('Active', 'Expired') default 'Active',
    primary key (membership_id)
)auto_increment = 2000;

-- Creating Transactions Table
create table transactions(
	transaction_id int auto_increment,
	membership_id int,
    book_id int,
    issued_date date default (current_date()),
    due_date date default (issued_date + INTERVAL 14 DAY),
    return_date date default null,
    late_fee int default 0,
    primary key (transaction_id)
);


alter table catogery auto_increment = 100;

-- Creating Reservations Table
create table reservation (
	membership_id int,
    book_id int,
    current_status enum('Reserved', 'Canceled','Issued')
);


alter table catogery auto_increment = 310;


alter table books
add constraint b_a_id foreign key(author_id) references authors(author_id);


alter table books
add constraint b_c_id foreign key(catogery_id) references catogery(catogery_id);


alter table transactions
add constraint t_m_id foreign key(membership_id) references members(membership_id);

alter table transactions
add constraint t_b_id foreign key(book_id) references books(book_id);

alter table reservation
add constraint r_b_id foreign key(book_id) references books(book_id);



alter table reservation
add constraint r_m_id foreign key(membership_id) references members(membership_id);

insert into authors  (first_name,last_name) values 
	('Jane','Austen'),
    ('Charles','Dickens'),
    ('Mark','Twain'),
    ('Virginia', 'Woolf'),
    ('Leo','Tolstoy'),
    ('Fyodor','Dostoevsky'),
    ('Haruki','Murakami')
;

insert into books  (book_name,author_id,publish_date,total_copies,available_copies) values 
	('Pride and Prejudice',200, '1813-01-28', 7, 5),
    ('Great Expectations',201, '1861-08-28', 5, 3),
    ('Adventures of Huckleberry Finn',202,'1884-12-10',10,5),
    ('To the Lighthouse',203, '1927-05-05',6,4),
    ('War and Peace',204,'1867-01-01',4,2),
    ('Crime and Punishment',205,'1866-01-01',5,3),
    ('Norwegian Wood',206,'1987-01-01',3,2)
;

insert into catogery (catogery_name) values 
	('Fantasy'), ('Mystery'), ('Romance'), ('Hostorical Fiction'), ('Crime Fiction'), ('Histoy'), ('Self-Help');
    
start transaction; 

savepoint ek;

update books
set catogery_id = 310 where book_name = 'Pride and Prejudice';

update books
set catogery_id = 311 where book_name = 'Great Expectations';

update books
set catogery_id = 312 where book_name = 'Adventures of Huckleberry Finn';

update books
set catogery_id = 310 where book_name = 'To the Lighthouse';

update books
set catogery_id = 316 where book_name = 'War and Peace';

update books
set catogery_id = 314 where book_name = 'Crime and Punishment';

update books
set catogery_id = 312 where book_name = 'Norwegian Wood';

commit;

-- Starting the transaction
start transaction;

-- first save point
savepoint fst;
-- inserting into members tables
insert into members (first_name,last_name,phone) values 
	('Zyna','Vankayala',7054986515),
    ('Tripsy','Sanniganti',9898659845),
    ('Nimy','Sanniganti',8989878584),
    ('Paul','pakodi',9988995465)
;

-- commiting the changes
commit;











