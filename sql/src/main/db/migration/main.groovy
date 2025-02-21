databaseChangeLog() {
    changeSet(id: 'create permission', author: 'Anonymous') {
        sqlFile(path: 'changesets/V1_0__create_user_permission.sql')
    }
    changeSet(id: 'create extension', author: 'Anonymous') {
        sqlFile(path: 'changesets/V1_1__create_extension.sql')
    }
    changeSet(id: 'create customer table', author: 'Anonymous') {
        sqlFile(path: 'changesets/V2_0__create_customer_table.sql')
    }
    changeSet(id: 'create transaction table', author: 'Anonymous') {
        sqlFile(path: 'changesets/V3_0__create_transaction_table.sql')
    }

    changeSet(id: 'import data', author: 'Anonymous') {
        sqlFile(path: 'datasets/common_data_dump.sql')
    }
}
