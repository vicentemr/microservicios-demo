INSERT INTO invoice (id, number_invoice, description, customer_id, create_at, state) VALUES(1, '0001', 'invoice office items', 1, NOW(),'CREATED');

INSERT INTO invoice_item ( id, product_id, quantity, price ) VALUES(1, 1 , 1, 178.89);
INSERT INTO invoice_item ( id, product_id, quantity, price)  VALUES(2, 2 , 2, 12.5);
INSERT INTO invoice_item ( id, product_id, quantity, price)  VALUES(3, 3 , 1, 40.06);