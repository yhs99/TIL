-- 1)
CREATE TABLE MEMBER(
    id       varchar2(20),
    password varchar2(40) not null,
    regno    varchar2(13) not null,
    mobile   varchar2(13),
    address  varchar2(100),
    constraint member_id_pk primary key(id),
    constraint member_regno_uq unique(regno),
    constraint member_mobile_uq unique(mobile)
);

-- 2)
CREATE TABLE book(
    code    number(4),
    title   varchar2(50) not null,
    count   number(6),
    price   number(10),
    publish varchar2(50),
    constraint book_code_pk primary key(code)
);

--3)
CREATE TABLE bookOrder(
    orderno varchar2(10),
    id not null,
    code not null,
    count   number(6),
    orderDate date,
    constraint bookOrder_orderno_pk primary key(orderno),
    constraint bookOrder_id_fk foreign key (id) references member(id),
    constraint bookOrder_code_fk foreign key (code) references book(code)
);