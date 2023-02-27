package com.ceiba.configuracion;

import com.ceiba.book.port.dao.BookDao;
import com.ceiba.book.port.repository.BookRepository;
import com.ceiba.book.service.CreateBookService;
import com.ceiba.book.service.UpdateAllBookDataService;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.factura.servicio.ServicioAnular;
import com.ceiba.factura.servicio.ServicioFacturar;
import com.ceiba.rating.port.dao.RatingDao;
import com.ceiba.rating.port.repository.RatingRepository;
import com.ceiba.rating.service.CreateRatingService;
import com.ceiba.rating.service.UpdateStarsRatingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {


    @Bean
    public ServicioFacturar servicioFacturar(RepositorioFactura repositorioFactura) {
        return new ServicioFacturar(repositorioFactura);
    }

    @Bean
    public ServicioAnular servicioAnular(RepositorioFactura repositorioFactura) {
        return new ServicioAnular(repositorioFactura);
    }

    @Bean
    public CreateBookService createBookService(BookRepository bookRepository) {
        return new CreateBookService(bookRepository);
    }

    @Bean
    public UpdateAllBookDataService updateAllBookDataService(BookRepository bookRepository, BookDao bookDao) {
        return new UpdateAllBookDataService(bookRepository, bookDao);
    }

    @Bean
    public CreateRatingService createRatingService(RatingRepository ratingRepository, BookDao bookDao) {
        return new CreateRatingService(ratingRepository, bookDao);
    }

    @Bean
    public UpdateStarsRatingService updateStarsRatingService(RatingRepository ratingRepository, RatingDao ratingDao) {
        return new UpdateStarsRatingService(ratingRepository, ratingDao);
    }
}
