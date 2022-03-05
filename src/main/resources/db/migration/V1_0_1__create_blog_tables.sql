create table "user"
(
    id        serial  not null,
    username  varchar not null,
    password  varchar not null,
    full_name varchar not null,
    constraint user_pk
        primary key (id)
);

create unique index user_username_uindex
    on "user" (username);

create table blog
(
    id         serial    not null,
    title      varchar   not null,
    content    text,
    author_id  integer   not null,
    created_at timestamp not null,
    constraint post_pk
        primary key (id),
    constraint fk_blog_user
        foreign key (author_id) references "user"
);

create table comment
(
    id      serial  not null,
    content text    not null,
    blog_id integer not null,
    user_id integer not null,
    constraint comment_pk
        primary key (id),
    constraint fk_comment_blog
        foreign key (blog_id) references blog,
    constraint fk_comment_user
        foreign key (user_id) references "user"
);

create table reaction
(
    id      serial  not null,
    type    integer not null,
    blog_id integer not null,
    user_id integer not null,
    constraint reaction_pk
        primary key (id),
    constraint fk_reaction_blog
        foreign key (blog_id) references blog,
    constraint fk_reaction_user
        foreign key (user_id) references "user"
);

create table tag
(
    id   serial  not null,
    name varchar not null,
    constraint tag_pk
        primary key (id)
);

create unique index tag_name_uindex
    on tag (name);

create table tag_relation
(
    id      serial  not null,
    blog_id integer not null,
    tag_id  integer not null,
    constraint tag_relation_pk
        primary key (id),
    constraint fk_tag_relation_blog
        foreign key (blog_id) references blog,
    constraint fk_tag_relation_tag
        foreign key (tag_id) references tag
);

