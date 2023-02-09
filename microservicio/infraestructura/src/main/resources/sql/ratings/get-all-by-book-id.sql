select id, id_book, stars
  from ratings
 where id_book = :bookId
 order by id_book asc
