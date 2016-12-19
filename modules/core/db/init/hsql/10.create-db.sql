-- begin DEMO_TASK
create table DEMO_TASK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    EMPLOYEE_ID varchar(36),
    CAPTION varchar(255) not null,
    DESCRIPTION longvarchar,
    START_DATE timestamp not null,
    END_DATE timestamp not null,
    STYLE_NAME varchar(255),
    ALL_DAY boolean,
    --
    primary key (ID)
)^
-- end DEMO_TASK
-- begin DEMO_EMPLOYEE
create table DEMO_EMPLOYEE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end DEMO_EMPLOYEE
