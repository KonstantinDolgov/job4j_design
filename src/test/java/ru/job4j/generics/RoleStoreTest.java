package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenRoleIsAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Admin");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        Role result = store.findById("7");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleIsAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.add(new Role("1", "Client"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Admin");
    }

    @Test
    void whenReplaceThenRoleIsClient() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.replace("1", new Role("1", "Client"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Client");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRole() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.replace("7", new Role("7", "Client"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Admin");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRoleIsAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.delete("7");
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Admin");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        boolean rsl = store.replace("1", new Role("1", "Client"));
        assertThat(rsl).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        boolean rsl = store.replace("7", new Role("7", "Client"));
        assertThat(rsl).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        boolean rsl = store.delete("1");
        assertThat(rsl).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        boolean rsl = store.delete("2");
        assertThat(rsl).isFalse();
    }
}