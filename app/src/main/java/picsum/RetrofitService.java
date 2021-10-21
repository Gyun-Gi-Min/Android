package picsum;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("/v2/list")
    public Call<List<PicsumVO>> getList();  //List = 여러개의 데이터가 넘어옴
}
