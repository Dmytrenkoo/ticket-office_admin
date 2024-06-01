package ua.com.kisit.ticketoffice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @Size(min = 2, max = 50, message = "Значення логіна має знаходитись в діапазоні від 2 до 50 символів")
    private String username;
    @Size(min = 4, message = "Пароль має бути більшим 4 символів")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Roles> rolesset = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRolesset();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Roles{" + rolesset +
                '}';
    }
}
