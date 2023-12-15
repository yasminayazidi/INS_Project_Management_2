package ins.bizminder.web.BizMinder.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

public class Company extends AbstractEntity{
    @Column(unique = true)
    private String corporateName;
    private String phone;
    private String address;
    private String logo;
    @Column(unique = true)
    private String siret;

}
