package at.htl.person;

import org.assertj.db.type.Source;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import java.sql.SQLSyntaxErrorException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.db.output.Outputs.output;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {


    static String url = "jdbc:derby://localhost:1527/db";
    static String username = "app";
    static String password = "app";

    @Test
    void test001() {
        Source source = new Source(
                url,
                username,
                password);
        Table table = new Table(source, "MY_PERSON");
//        assertThatThrownBy(() -> {
//            output(table).toConsole();
//            })
//                .isInstanceOf(org.assertj.db.exception.AssertJDBException.class)
//                .hasCauseInstanceOf(SQLSyntaxErrorException.class)
//                .hasMessageContaining("Table/View 'MY_PERSON' does not exist");
        org.assertj.db.api.Assertions.assertThat(table)
                .row(0)
                .hasValues(1L,
                        "Leonding",
                        "Susi"
                );
        output(table).toConsole();
    }
}