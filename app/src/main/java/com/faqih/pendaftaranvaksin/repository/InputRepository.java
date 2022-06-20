package com.faqih.pendaftaranvaksin.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.faqih.pendaftaranvaksin.dao.InputDao;
import com.faqih.pendaftaranvaksin.database.VaccineDatabase;
import com.faqih.pendaftaranvaksin.ui.inputdata.ModelInput;

import java.util.List;

public class InputRepository {

    private InputDao inputDao;
    private LiveData<List<ModelInput>> allData;

    public InputRepository(Application application) {
        VaccineDatabase database = VaccineDatabase.getInstance(application);
        inputDao = database.inputDao();
        allData = inputDao.getAllData();
    }

    public void insert(ModelInput note) {
        new InsertNoteAsyncTask(inputDao).execute(note);
    }

    public void update(ModelInput note) {
        new UpdateNoteAsyncTask(inputDao).execute(note);
    }

    public void delete(ModelInput note) {
        new DeleteNoteAsyncTask(inputDao).execute(note);
    }

    public void deleteAllNotes() {
        new DeleteAllNoteAsyncTask(inputDao).execute();
    }

    public LiveData<List<ModelInput>> getAllData() {
        return allData;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<ModelInput, Void, Void> {

        private InputDao inputDao;

        private InsertNoteAsyncTask(InputDao inputDao) {
            this.inputDao = inputDao;
        }

        @Override
        protected Void doInBackground(ModelInput... modelInputs) {
            inputDao.insert(modelInputs[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<ModelInput, Void, Void> {

        private InputDao inputDao;

        private UpdateNoteAsyncTask(InputDao inputDao) {
            this.inputDao = inputDao;
        }

        @Override
        protected Void doInBackground(ModelInput... modelInputs) {
            inputDao.update(modelInputs[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<ModelInput, Void, Void> {

        private InputDao inputDao;

        private DeleteNoteAsyncTask(InputDao inputDao) {
            this.inputDao = inputDao;
        }

        @Override
        protected Void doInBackground(ModelInput... modelInputs) {
            inputDao.delete(modelInputs[0]);
            return null;
        }
    }

    private static class DeleteAllNoteAsyncTask extends AsyncTask<ModelInput, Void, Void> {

        private InputDao inputDao;

        private DeleteAllNoteAsyncTask(InputDao inputDao) {
            this.inputDao = inputDao;
        }

        @Override
        protected Void doInBackground(ModelInput... modelInputs) {
            inputDao.deleteAllData();
            return null;
        }
    }

}
