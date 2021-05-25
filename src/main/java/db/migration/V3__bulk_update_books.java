package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.ResultSet;
import java.sql.Statement;

public class V3__bulk_update_books extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        try (Statement select = context.getConnection().createStatement()) {
            try (ResultSet rows = select.executeQuery("SELECT id FROM books ORDER BY id")) {
                while (rows.next()) {
                    int id = rows.getInt(1);
                    String nameToChange = "LHWN2";
                    try (Statement update = context.getConnection().createStatement()) {
                        update.execute("UPDATE books SET name='" + nameToChange + "'WHERE id=" + id);
                    }
                }
            }
        }
    }
}
