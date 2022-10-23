INSERT INTO product_type (id, name)
values (1, 'Laptop');

INSERT INTO products (id, name, current_stock, description) VALUES (1, 'Dell Precision 5550', 99, 'The worlds smallest and thinnest 15" mobile workstation.');


INSERT INTO products (id, name, current_stock, description, type_id)
VALUES (1, 'Dell Precision 5550', 99, 'The worlds smallest and thinnest 15" mobile workstation.',1),
       (1, 'Dell Precision 5750', 5, 'Precision 5570 Workstation. Stuns from every angle.',1);

