insert into public.user (id, username, password, full_name) values (DEFAULT, 'taivtse', 'test', 'Võ Thành Tài');

insert into public.blog (id, title, content, author_id, created_at) values (1, 'Create a new implementation', 'Share your knowledge and enpower the community by creating a new implementation', 1, '2022-03-05 22:56:58.525000');
insert into public.blog (id, title, content, author_id, created_at) values (2, 'Explore implementations', 'Over 100 implementations have been created using various languages, libraries, and frameworks. Explore them on CodebaseShow.', 1, '2022-03-05 22:57:40.426000');
insert into public.blog (id, title, content, author_id, created_at) values (3, 'Welcome to RealWorld project', 'See how the exact same Medium.com clone (called Conduit) is built using different frontends and backends. Yes, you can mix and match them, because they all adhere to the same API spec.', 1, '2022-03-05 22:58:15.478000');

insert into public.comment (id, content, blog_id, user_id) values (1, 'Good blog content', 1, 1);

insert into public.tag (id, name) values (1, 'implementations');
insert into public.tag (id, name) values (2, 'codebaseShow');
insert into public.tag (id, name) values (3, 'welcome');
insert into public.tag (id, name) values (4, 'introduction');

insert into public.tag_relation (id, blog_id, tag_id) values (1, 1, 1);
insert into public.tag_relation (id, blog_id, tag_id) values (2, 2, 1);
insert into public.tag_relation (id, blog_id, tag_id) values (3, 2, 2);
insert into public.tag_relation (id, blog_id, tag_id) values (4, 3, 3);
insert into public.tag_relation (id, blog_id, tag_id) values (5, 3, 4);
