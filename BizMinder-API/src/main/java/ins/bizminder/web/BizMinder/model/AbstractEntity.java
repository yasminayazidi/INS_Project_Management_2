package ins.bizminder.web.BizMinder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.CloseableThreadContext;
import org.hibernate.type.SerializableType;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;
@Data
@AllArgsConstructor

@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    @JsonIgnore
    private String createdBy;
    @JsonIgnore
    private String ModifiedBy;
    @JsonIgnore
    private Instant modifiedDate;
    @Column(nullable = false)
    @JsonIgnore
    private Instant createdDate;
}
