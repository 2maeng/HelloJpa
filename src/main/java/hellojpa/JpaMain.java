package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Member member = em.find(Member.class, 150L);

            member.setName("AAAAA");

//            em.detach(member);
//            em.clear(); 영속성 상태인 것들을 통으로 지워 버림

            System.out.println("=====================");

            // 생성
            // 비영속
//            Member member = new Member();
//
//            member.setId(2L);
//            member.setName("HelloB");
//
            // 영속
//            em.persist(member); // 이렇게 하면 멤버가 저장이 됨
            // JPA에는 모든 트랜잭션이 중요함

            // 조회
//            Member findMember = em.find(Member.class, 1L);

            // 수정
//            findMember.setName("HelloJPA");

            // 삭제
//            em.remove(findMember);

//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10) // 1번 부터 10개 가져와
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            tx.commit();
        }
        catch (Exception e) {
            tx.rollback();
        }
        finally {
            em.close();
        }

        emf.close();
    }

}
