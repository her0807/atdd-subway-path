package wooteco.subway.reopository;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import wooteco.subway.domain.Line;
import wooteco.subway.reopository.dao.LineDao;
import wooteco.subway.reopository.entity.LineEntity;

@Repository
public class LineRepository {

    private final LineDao lineDao;

    public LineRepository(LineDao lineDao) {
        this.lineDao = lineDao;
    }

    public Long save(Line line) {
        return lineDao.save(new LineEntity(line.getName(), line.getColor()));
    }

    public Optional<Line> findById(Long id) {
        LineEntity lineEntity = lineDao.findById(id).orElse(null);
        if (lineEntity.equals(null)) {
           return Optional.ofNullable(null);
        }
        return Optional.ofNullable(new Line(lineEntity.getId(), lineEntity.getName(), lineEntity.getColor()));
    }

    public List<Line> findAll() {
        List<LineEntity> list = lineDao.findAll();
        return list.stream()
                .map(entity -> new Line(entity.getId(), entity.getName(), entity.getColor()))
                .collect(toList());
    }

    public void modifyById(Long id, Line line) {
        lineDao.modifyById(id, new LineEntity(line.getName(), line.getColor()));
    }

    public void deleteById(Long id) {
        lineDao.deleteById(id);
    }

    public boolean existByNameAndColor(String name, String color) {
        return lineDao.existByNameAndColor(name, color);
    }
}
