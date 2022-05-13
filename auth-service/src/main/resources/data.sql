-- Create roles
insert into role (id, name)
values ('e08352cb-b876-4dad-adc3-bd363b23bec1', 'admin');

insert into role (id, name)
values ('980b4eb7-fd83-458c-be08-48b4e8d2dca4', 'user');

-- Create permissions
insert into permission(id, name)
values ('e3a43be3-8f31-4e75-b909-794f98267cfb', 'read_user');

insert into permission(id, name)
values ('205d3196-e1c4-4e4e-b3d3-6c6930b8ff20', 'write_user');

-- Create users default user: admin pass: admin
INSERT INTO USER (id, username, password, email, business_unit, role_id)
VALUES ('5072d8b9-d1fc-40fb-97ab-83ddc3f60eda', 'admin',
        '{bcrypt}$2a$10$6zSRiGXUifOYOMcHGowgO.miqnfhWmluezH4CyxhDahQBZWqAx7bO', 'admin@me.com', 'NY-BU',
        'e08352cb-b876-4dad-adc3-bd363b23bec1');

-- Bind Roles to Permissions
insert into role_permission (role_id, permission_id)
values ('e08352cb-b876-4dad-adc3-bd363b23bec1', 'e3a43be3-8f31-4e75-b909-794f98267cfb');

insert into role_permission (role_id, permission_id)
values ('e08352cb-b876-4dad-adc3-bd363b23bec1', '205d3196-e1c4-4e4e-b3d3-6c6930b8ff20');

insert into role_permission (role_id, permission_id)
values ('980b4eb7-fd83-458c-be08-48b4e8d2dca4', 'e3a43be3-8f31-4e75-b909-794f98267cfb');

-- Create app client default-clientId: shop-app, default-clientSecret: 123456
INSERT INTO app_client (id,
                        client_id,
                        client_secret,
                        scope,
                        authorized_grant_types,
                        web_server_redirect_uri,
                        authorities,
                        access_token_validity,
                        refresh_token_validity,
                        resource_ids,
                        add_info,
                        auto_approve)
VALUES ('2d638127-572a-4b6a-bc37-876257511067',
        'shop-app',
        '{bcrypt}$2a$10$9GWx0Xfl4YjzrMomdh1TzuYFg3iZ4B0DTwgWueTddmBNKYz3TPIu6',
        'read,write',
        'password,authorization_code,refresh_token,client_credentials',
        'http://localhost:8082/login',
        'ROLE_CLIENT',
        36000,
        36000,
        'user-resource,order-resource',
        null,
        'true');

-- Create app client default-clientId: order-service, default-clientSecret: 123456
INSERT INTO app_client (id,
                        client_id,
                        client_secret,
                        scope,
                        authorized_grant_types,
                        web_server_redirect_uri,
                        authorities,
                        access_token_validity,
                        refresh_token_validity,
                        resource_ids,
                        add_info,
                        auto_approve)
VALUES ('fad05c76-f571-4102-b2de-8a7af744315f',
        'order-service',
        '{bcrypt}$2a$10$9GWx0Xfl4YjzrMomdh1TzuYFg3iZ4B0DTwgWueTddmBNKYz3TPIu6',
        'read,write',
        'password,authorization_code,refresh_token,client_credentials',
        'http://localhost:8082/login',
        'ROLE_CLIENT',
        36000,
        36000,
        'user-resource,order-resource',
        null,
        'true');

-- Create app client default-clientId: user-service, default-clientSecret: 123456
INSERT INTO app_client (id,
                        client_id,
                        client_secret,
                        scope,
                        authorized_grant_types,
                        web_server_redirect_uri,
                        authorities,
                        access_token_validity,
                        refresh_token_validity,
                        resource_ids,
                        add_info,
                        auto_approve)
VALUES ('02a2572c-d2dc-4b62-8c89-5d80f46f5b4c',
        'user-service',
        '{bcrypt}$2a$10$9GWx0Xfl4YjzrMomdh1TzuYFg3iZ4B0DTwgWueTddmBNKYz3TPIu6',
        'read,write',
        'password,authorization_code,refresh_token,client_credentials',
        'http://localhost:8082/login',
        'ROLE_CLIENT',
        36000,
        36000,
        'user-resource,order-resource',
        null,
        'true');
