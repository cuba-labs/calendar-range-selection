update DEMO_TASK set START_DATE = current_timestamp where START_DATE is null ;
alter table DEMO_TASK alter column START_DATE set not null ;
update DEMO_TASK set END_DATE = current_timestamp where END_DATE is null ;
alter table DEMO_TASK alter column END_DATE set not null ;
