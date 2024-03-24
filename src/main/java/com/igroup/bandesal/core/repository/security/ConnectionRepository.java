package com.igroup.bandesal.core.repository.security;

import com.igroup.bandesal.core.entity.bandesal.Reader;
import com.igroup.bandesal.core.entity.security.Connection;
import com.igroup.bandesal.core.entity.security.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.util.*;

@ApplicationScoped
public class ConnectionRepository implements PanacheRepository<Connection> {

    private static final String CONNECTION_PATH = "connections";

    public Connection verifictToken(String token) {

        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);

        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Connection> query = builder.createQuery(Connection.class);
        List<Predicate> predicates = new ArrayList<>();
        Root<Connection> root = query.from(Connection.class);

        predicates.add(
                builder.equal(
                        root.get("token"),
                        token));

        predicates.add(
                builder.greaterThanOrEqualTo(
                        root.get("date"),
                        now ));

        predicates.add(
                builder.lessThanOrEqualTo(
                        root.get("date"),
                        this.getEndTimeToken(root.get("duration"),calendar) ));

        query.select(root).where(predicates.toArray(Predicate[]::new)).distinct(true);

        TypedQuery<Connection> typedQuery = getEntityManager().createQuery(query);

        return typedQuery.getSingleResult();
    }

    private Date getEndTimeToken( Object duration,Calendar calendar){
        calendar.add(Calendar.MINUTE, Integer.parseInt( duration.toString() ));
        return calendar.getTime();
    }


}
