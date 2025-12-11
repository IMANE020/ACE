package ma.formation.rest.dao;
import ma.formation.rest.service.service.model.Article;
import java.util.List;

public interface IDao {
    Article findById(Long id);
    List<Article> findAll();
    void save(Article article);
    void deleteById(Long id);
}
