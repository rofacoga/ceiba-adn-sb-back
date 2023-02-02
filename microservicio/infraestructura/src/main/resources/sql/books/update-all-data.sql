UPDATE books b
SET b.title = :title, b.author = :author
WHERE b.id = :id
