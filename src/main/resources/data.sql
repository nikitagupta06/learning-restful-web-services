insert into user_details(id, birth_date, name)
values(10001, current_date(), 'Nikita');

insert into user_details(id, birth_date, name)
values(10002, current_date(), 'Priya');

insert into user_details(id, birth_date, name)
values(10003, current_date(), 'Anu');

insert into post(id, description, user_id)
values(20001, 'I want to learn AWS!',10001);

insert into post(id, description, user_id)
values(20002, 'I want to learn Azure!',10001);

insert into post(id, description, user_id)
values(20003, 'I want to be AWS certified!',10002);

insert into post(id, description, user_id)
values(20004, 'I want to be Azure certified!',10002);