    private static final String SQL_INSERT = "INSERT INTO FUNCIONARIO (NOME, SALARIO)"
            + " VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE FUNCIONARIO SET "
            + " NOME = ?, "
            + " SALARIO = ? "
            + " WHERE CODIGO = ? ";
    private static final String SQL_DELETE = "DELETE FROM FUNCIONARIO WHERE CODIGO = ?";
    private static final String SQL_QUERY_ALL = "SELECT CODIGO, NOME, SALARIO FROM FUNCIONARIO";
    private static final String SQL_QUERY_ONE = "SELECT CODIGO, NOME, SALARIO FROM FUNCIONARIO WHERE CODIGO = ?";