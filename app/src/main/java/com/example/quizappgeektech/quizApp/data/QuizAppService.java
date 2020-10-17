package com.example.quizappgeektech.quizApp.data;

import android.util.Log;

import com.example.quizappgeektech.quizApp.interfaces.IQuizQuestionsService;
import com.example.quizappgeektech.quizApp.models.CategoryModel;
import com.example.quizappgeektech.quizApp.models.QuizModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class QuizAppService implements IQuizQuestionsService {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    QuizApi service = retrofit.create(QuizApi.class);

    public void getQuestions(QuizModelCallback callback, Integer amount, Integer category, String difficulty) {
        Call<QuizModel> call = service.getQuestion(amount, category, difficulty);
        call.enqueue(new Callback<QuizModel>() {
            @Override
            public void onResponse(Call<QuizModel> call, Response<QuizModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                    Log.d("ololo", "onSuccess" + response.body().getResults().size());

                }
            }

            @Override
            public void onFailure(Call<QuizModel> call, Throwable t) {
                Log.d("ololo", "onFailure " + t.getMessage());
            }
        });
    }

    public void getCategories(QuizApiCallback callback) {
        Call<CategoryModel> call = service.getCategory();
        call.enqueue(new Callback<CategoryModel>() {
            @Override
            public void onResponse(Call<CategoryModel> call, Response<CategoryModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());

                }
            }

            @Override
            public void onFailure(Call<CategoryModel> call, Throwable t) {
                callback.onFailure(t);

            }
        });
    }

    @Override
    public void getQuestions(QuestionsCallback callback, Integer amount, Integer category, String difficulty) {
        Call<QuizModel> call = service.getQuestion(amount, category, difficulty);
        call.enqueue(new Callback<QuizModel>() {
            @Override
            public void onResponse(Call<QuizModel> call, Response<QuizModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                    Log.d("ololo", "onSuccess" + response.body().getResults().size());

                }
            }

            @Override
            public void onFailure(Call<QuizModel> call, Throwable t) {
                Log.d("ololo", "onFailure " + t.getMessage());
            }
        });
    }

    public interface QuizApiCallback {
        void onSuccess(CategoryModel categoryModel);

        void onFailure(Throwable th);
    }

    public interface QuizModelCallback {
        void onSuccess(QuizModel model);

        void onFailure(Throwable th);
    }

    public interface QuizApi {
        @GET("api_category.php")
        Call<CategoryModel> getCategory();

        @GET("api.php")
        Call<QuizModel> getQuestion(@Query("amount") int amount,
                                    @Query("category") int category,
                                    @Query("difficulty") String difficulty);
    }

}
