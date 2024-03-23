SELECT
    o.order_id,
    p.product_name,
    c.customer_name,
    oi.quantity,
    CASE
        WHEN oi.quantity > 10 THEN rt.rule_value
        ELSE 'Low Quantity'
    END AS quantity_category,
    COALESCE(p.product_type, 'Unknown') AS product_type,
    GREATEST(o.order_total, 0) AS adjusted_total
FROM
    orders o
JOIN
    order_items oi ON o.order_id = oi.order_id
JOIN
    products p ON oi.product_id = p.product_id
JOIN
    customers c ON o.customer_id = c.customer_id
LEFT JOIN
    rule_table rt ON oi.quantity > 10 AND rt.rule_name = 'High Quantity'
WHERE
    o.order_status = 'Shipped'
    AND c.country = 'USA'
ORDER BY
    o.order_date DESC;
