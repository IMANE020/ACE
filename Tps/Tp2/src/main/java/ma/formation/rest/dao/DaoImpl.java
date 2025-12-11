package ma.formation.rest.dao;
import ma.formation.rest.service.service.model.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DaoImpl implements IDao {
    private static final List<Article> database = new ArrayList<>
            (Arrays.asList(
                    new Article(1L, "PC PORTABLE HP I7", 15000.0, 10.0),
                    new Article(2L, "ECRAN", 1500.0, 10.0),
                    new Article(3L, "CAMERA LG", 3000.0, 10.0),
                    new Article(4L, "SOURIS", 200.0, 10.0)));

    @Override
    public Article findById(Long id) {
        return database.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Article> findAll() {
        return database;
    }

    @Override
    public void save(Article article) {
        database.add(article);
    }

    @Override
    public void deleteById(Long id) {
        database.remove(database.stream().filter(a -> id.equals(a.getId())).findFirst());
    }
}
