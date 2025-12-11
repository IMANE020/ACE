package ma.formation.rest.service;

import ma.formation.rest.domaine.ArticleDTO;

import java.util.List;
public interface IService {
    ArticleDTO getById(Long id);

    List<ArticleDTO> getAll();

    void create(ArticleDTO article);

    void update(Long id, ArticleDTO article);

    void deleteById(Long id);

}
