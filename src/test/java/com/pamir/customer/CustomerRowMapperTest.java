package com.pamir.customer;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class CustomerRowMapperTest {

    @Test
    void mapRow() throws SQLException {
        // Given
        CustomerRowMapper customerRowMapper = new CustomerRowMapper();

        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getInt("age")).thenReturn(19);
        when(resultSet.getString("name")).thenReturn("Pamir");
        when(resultSet.getString("email")).thenReturn("Pamir@gmail.com");
        when(resultSet.getString("gender")).thenReturn("MALE");
        when(resultSet.getString("password")).thenReturn("password");
        when(resultSet.getString("profile_image_id")).thenReturn("22222");


        // When
        Customer actual = customerRowMapper.mapRow(resultSet, 1);

        // Then
        Customer expected = new Customer(
                1,
                "Pamir",
                "Pamir@gmail.com",
                19
        );
        assertThat(actual).isEqualTo(expected);
    }

}