package com.event.app.model;

import com.event.app.config.security.Role;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Document
@Data
@Builder
public class User implements UserDetails {

    @MongoId
    private String id;

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Set<Role> roles;

    @DBRef
    private List<Event> eventsCreated;

    @DBRef
    private List<Event> eventsJoined;

    @DBRef
    private List<User> friendList;

    public boolean isAdmin() {
        return this.roles.contains(Role.ADMIN);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
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

    public List<Event> getCombinedEvents() {
        Stream<Event> eventCreatedStream = eventsCreated != null ? eventsCreated.stream() : Stream.empty();
        Stream<Event> eventJoinedStream = eventsJoined != null ? eventsJoined.stream() : Stream.empty();
        return Stream.concat(eventCreatedStream, eventJoinedStream)
                .collect(Collectors.toList());
    }
}
