/**
 * Author:  fabrix
 * Created: 29-Dec-2018
 */
drop table book_stats;
drop table processed_book_stats;
create view book_stats as
select book_id, name as instrument, sum(quantity) demand, max(quantity) biggest, min(quantity) smallest, min(entry_date) earliest,
 max(entry_date) latest
from financial_order fo inner join instrument i on fo.instrument_id = i.id
group by book_id, name;

create view processed_book_stats as
select book_id, name as instrument, sum(quantity) demand, max(quantity) biggest, min(quantity) smallest, min(entry_date) earliest,
 max(entry_date) latest, valid, sum(o.quantity) execution_quantity, max(e.price) price from financial_order fo
inner join instrument i on fo.instrument_id = i.id
inner join order_execution o on fo.id = o.financial_order_id 
inner join execution e on e.id = o.execution_id
group by book_id, valid, name;

insert into INVESTOR VALUES(1, 'Investor1');
insert into INVESTOR VALUES(2, 'Investor2');
insert into INVESTOR VALUES(3, 'Investor3');
insert into INVESTOR VALUES(4, 'Investor4');
insert into INVESTOR VALUES(5, 'Investor5');
insert into INVESTOR VALUES(6, 'Investor6');
insert into INVESTOR VALUES(7, 'Investor7');
insert into INVESTOR VALUES(8, 'Investor8');
insert into INVESTOR VALUES(9, 'Investor9');
insert into INVESTOR VALUES(10, 'Investor10');

insert into INSTRUMENT values(1, 'Instrument1');
insert into INSTRUMENT values(2, 'Instrument2');
insert into INSTRUMENT values(3, 'Instrument3');
insert into INSTRUMENT values(4, 'Instrument4');
insert into INSTRUMENT values(5, 'Instrument5');
insert into INSTRUMENT values(6, 'Instrument6');
insert into INSTRUMENT values(7, 'Instrument7');
insert into INSTRUMENT values(8, 'Instrument8');
insert into INSTRUMENT values(9, 'Instrument9');
insert into INSTRUMENT values(10, 'Instrument10');

insert into BOOK values(1, false, false, 1);
insert into BOOK values(2, false, false, 2);
insert into BOOK values(3, false, false, 3);
insert into BOOK values(4, false, false, 4);
insert into BOOK values(5, false, false, 5);
insert into BOOK values(6, false, false, 6);
insert into BOOK values(7, false, false, 7);
insert into BOOK values(8, false, false, 8);
insert into BOOK values(9, false, false, 9);
insert into BOOK values(10, false, false, 10);

insert into EXECUTION values(1, 95, 1000, 1);
insert into EXECUTION values(2, 95, 1500, 2);
insert into EXECUTION values(3, 95, 2000, 3);
insert into EXECUTION values(4, 95, 2500, 4);
insert into EXECUTION values(5, 95, 3000, 5);
insert into EXECUTION values(6, 95, 3500, 6);
insert into EXECUTION values(7, 95, 4000, 7);
insert into EXECUTION values(8, 95, 4500, 8);
insert into EXECUTION values(9, 95, 5000, 9);
insert into EXECUTION values(10, 95, 5500, 10);