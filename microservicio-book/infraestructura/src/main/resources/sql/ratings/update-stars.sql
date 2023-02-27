UPDATE ratings r
   SET r.stars = :stars
 WHERE r.id = :id
   AND r.id_book = :bookId
