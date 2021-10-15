import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
    private Connection connection;
    private final String Get_Cars_Query = "Select * From cars";
    private final String Create_Car_Query = "Insert into cars(make, model, year_manufactured) values(?,?,?)";
    private final String Delete_Car_By_Id_Query = "Delete From cars Where id = ?";
    private final String Update_Year_Manufactured_By_Id_Query = "Update cars Set year_manufactured = ? where id = ?";

    public CarDao() {
        connection = DBConnection.getConnection();
    }
    public List<Cars> getCars() throws SQLException{
        ResultSet rs = connection.prepareStatement(Get_Cars_Query).executeQuery();
        List<Cars> cars = new ArrayList<Cars>();
        while(rs.next()){
        cars.add(new Cars(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
        }
        return cars;
        
    }
    public void createNewCar(String make, String model, int year_manufactured) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(Create_Car_Query);
        ps.setString(1, make);
        ps.setString(2, model);
        ps.setInt(3, year_manufactured);
        ps.executeUpdate();
    }
    public void deleteCar(int id) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(Delete_Car_By_Id_Query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
    public void updateYear(int year_manufactured, int id) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(Update_Year_Manufactured_By_Id_Query);
        ps.setInt(1, year_manufactured);
        ps.setInt(2, id);
        ps.executeUpdate();
    }
}
