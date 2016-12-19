-- begin DEMO_TASK
alter table DEMO_TASK add constraint FK_DEMO_TASK_EMPLOYEE foreign key (EMPLOYEE_ID) references DEMO_EMPLOYEE(ID)^
create index IDX_DEMO_TASK_EMPLOYEE on DEMO_TASK (EMPLOYEE_ID)^
-- end DEMO_TASK
