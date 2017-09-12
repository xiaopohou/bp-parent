package com.lhyzp.commons.utils;

import com.google.common.collect.Lists;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2017-9-7.
 */
public class SpecificationFactory {

    /**
     * 等于条件
     * @param attributte
     * @param value
     * @return
     */
    public static Specification equal(String attributte,String value){
        return (root, cq, cb) ->cb.equal(root.get(attributte),value);
    }

    /**
     * 模糊查询
     * @param attributte
     * @param value
     * @return
     */
    public static Specification like(String attributte,String value){
        return (root, cq, cb) ->cb.like(root.get(attributte),"%"+value+"%");
    }

    /**
     *范围区间条件
     * @param attribute
     * @return
     */
    public static Specification between(String attribute,int min,int max){
        return (root, cq, cb) ->cb.between(root.get(attribute),min,max);
    }
    public static Specification between(String attribute,double min,double max){
        return (root, cq, cb) ->cb.between(root.get(attribute),min,max);
    }

    /**
     * in条件查询
     * @param attributte
     * @return
     */
    public static Specification in(String attributte,Collection c){
        return (root, cq, cb) ->root.get(attributte).in(c);
    }


    public static Predicate[] getPredicate(){

        List<Predicate> predicates= Lists.newArrayList();

        Predicate[] arrayPredicates = new Predicate[predicates.size()];
        return predicates.toArray(arrayPredicates);

    }

}
