package com.faqih.pendaftaranvaksin.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.faqih.pendaftaranvaksin.repository.InputRepository;
import com.faqih.pendaftaranvaksin.ui.inputdata.ModelInput;

import java.util.List;

public class InputViewModel extends AndroidViewModel {

    private InputRepository repository;
    private LiveData<List<ModelInput>> allData;

    public InputViewModel(@NonNull Application application) {
        super(application);
        repository = new InputRepository(application);
        allData = repository.getAllData();
    }

    public void insert(ModelInput modelInput) {
        repository.insert(modelInput);
    }

    public void update(ModelInput modelInput) {
        repository.update(modelInput);
    }

    public void delete(ModelInput modelInput) {
        repository.delete(modelInput);
    }

    public void deleteAllData() {
        repository.deleteAllNotes();
    }

    public LiveData<List<ModelInput>> getAllData() {
        return allData;
    }

}
