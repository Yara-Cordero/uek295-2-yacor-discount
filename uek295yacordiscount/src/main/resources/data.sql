INSERT INTO discounts ("discount_id","code", "discount", "id_client")
VALUES (
        default,
        'HB4FG28',
        25,
        04684
       ),
       (
        default,
        'KWN9SWU',
        10,
        24123
       ),
       (
        default,
        'Q12M0SV',
        50,
        03933
       ),
       (
        default,
        'BV003YP',
        30,
        18294
       )
ON CONFLICT DO NOTHING;
INSERT INTO authorities("authority_id", "authority_name")
VALUES (1, 'READ'),
       (2, 'CREATE'),
       (3, 'UPDATE'),
       (4, 'DELETE')
ON CONFLICT DO NOTHING;
INSERT INTO roles("role_id", "role_name")
VALUES (1, 'ADMIN'),
       (2, 'USER')
ON CONFLICT DO NOTHING;
INSERT INTO roles_authorities("id_role", "id_authority")
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (2, 1)
ON CONFLICT DO NOTHING;
INSERT INTO users("password", "name", "user_role")
VALUES ('123', 'cooldude22', 1),
       ('123', 'tubularperson10', 2)
ON CONFLICT DO NOTHING;