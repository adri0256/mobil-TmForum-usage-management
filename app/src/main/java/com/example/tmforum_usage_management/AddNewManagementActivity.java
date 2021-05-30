package com.example.tmforum_usage_management;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.tmforum_usage_management.models.CharacteristicRelationship;
import com.example.tmforum_usage_management.models.Money;
import com.example.tmforum_usage_management.models.ProductRef;
import com.example.tmforum_usage_management.models.RatedProductUsage;
import com.example.tmforum_usage_management.models.RelatedParty;
import com.example.tmforum_usage_management.models.Usage;
import com.example.tmforum_usage_management.models.UsageCharacteristic;
import com.example.tmforum_usage_management.models.UsageSpecificationRef;
import com.example.tmforum_usage_management.models.UsageStatusType;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AddNewManagementActivity extends AppCompatActivity {
    private static final String LOG_TAG = AddNewManagementActivity.class.getName();

    final Context context = this;
    final Calendar myCalendar = Calendar.getInstance();

    private FirebaseFirestore mFirestore;
    private CollectionReference mCollectionReference;
    private String editKey;

    private ArrayList<Usage> mItems;
    private Usage mEditItem;

    // Models
    CharacteristicRelationship mCharacteristicRelationship;
    ProductRef mProductRef;
    RatedProductUsage mRatedProductUsage;
    RelatedParty mRelatedParty;
    UsageCharacteristic mUsageCharacteristic;
    UsageSpecificationRef mUsageSpecificationRef;
    Usage mUsage;

    //region ET's

    // Usage ET's
    EditText usageIdET;
    EditText usageHrefET;
    EditText usageUsageDateET;
    EditText usageUsageTypeET;
    EditText usageDescriptionET;
    Spinner usageStatusSP;
    EditText usageBaseTypeET;
    EditText usageSchemaLocationET;
    EditText usageTypeET;

    // Rated Product Usage ET's
    EditText bucketValueConvertedInAmountValueET;
    EditText bucketValueConvertedInAmountUnitET;
    RadioGroup isBilledRG;
    RadioGroup isTaxExemptRG;
    EditText offerTariffTypeET;
    EditText ratingAmountTypeET;
    EditText ratingDateET;
    EditText taxExcludedRatingAmountUnitET;
    EditText taxExcludedRatingAmountValueET;
    EditText taxIncludedRatingAmountUnitET;
    EditText taxIncludedRatingAmountValueET;
    EditText taxRateET;
    EditText usageRatingTagET;
    EditText RatedProductUsageBaseTypeET;
    EditText RatedProductUsageSchemaLocationET;
    EditText RatedProductUsageTypeET;

    // Product Reference ET's
    EditText ProductRefIdET;
    EditText ProductRefHrefET;
    EditText ProductRefNameET;
    EditText ProductRefRelationshipTypeET;
    EditText ProductRefBaseTypeET;
    EditText ProductRefReferedTypeET;
    EditText ProductRefSchemaLocationET;
    EditText ProductRefTypeET;

    // Related Party ET's
    EditText RelatedPartyIdET;
    EditText RelatedPartyHrefET;
    EditText RelatedPartyNameET;
    EditText RelatedPartyRoleET;
    EditText RelatedPartyBaseTypeET;
    EditText RelatedPartyReferedTypeET;
    EditText RelatedPartySchemaLocationET;
    EditText RelatedPartyTypeET;

    // Usage Characteristic ET's
    EditText UsageCharacteristicIdET;
    EditText UsageCharacteristicNameET;
    EditText UsageCharacteristicValueET;
    EditText UsageCharacteristicBaseTypeET;
    EditText UsageCharacteristicValueTypeET;
    EditText UsageCharacteristicSchemaLocationET;
    EditText UsageCharacteristicTypeET;

    // Characteristic Relationship ET's
    EditText CharacteristicRelationshipIdET;
    EditText CharacteristicRelationshipHrefET;
    EditText CharacteristicRelationshipRelationshipTypeET;
    EditText CharacteristicRelationshipBaseTypeET;
    EditText CharacteristicRelationshipSchemaLocationET;
    EditText CharacteristicRelationshipTypeET;

    // Usage Specification ET's
    EditText UsageSpecificationIdET;
    EditText UsageSpecificationHrefET;
    EditText UsageSpecificationNameET;
    EditText UsageSpecificationBaseTypeET;
    EditText UsageSpecificationReferedTypeET;
    EditText UsageSpecificationSchemaLocationET;
    EditText UsageSpecificationTypeET;

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_management);

        mFirestore = FirebaseFirestore.getInstance();
        mCollectionReference = mFirestore.collection("usage");
        mEditItem = new Usage();
        mItems = new ArrayList<>();

        //region findViewById

        // Usage
        //usageIdET = findViewById(R.id.usageId);
        usageHrefET = findViewById(R.id.usageHref);
        usageUsageDateET = findViewById(R.id.usageUsageDate);
        usageUsageTypeET = findViewById(R.id.usageUsageType);
        usageDescriptionET = findViewById(R.id.usageDescription);
        usageStatusSP = findViewById(R.id.usageStatus);
        usageBaseTypeET = findViewById(R.id.usageBaseType);
        usageSchemaLocationET = findViewById(R.id.usageSchemaLocation);
        usageTypeET = findViewById(R.id.usageType);

        // Rated Product Usage
        bucketValueConvertedInAmountValueET = findViewById(R.id.bucketValueConvertedInAmountValue);
        bucketValueConvertedInAmountUnitET = findViewById(R.id.bucketValueConvertedInAmountUnit);
        isBilledRG = findViewById(R.id.isBilled);
        isTaxExemptRG = findViewById(R.id.isTaxExempt);
        offerTariffTypeET = findViewById(R.id.offerTariffType);
        ratingAmountTypeET = findViewById(R.id.ratingAmountType);
        ratingDateET = findViewById(R.id.ratingDate);
        taxExcludedRatingAmountUnitET = findViewById(R.id.taxExcludedRatingAmountUnit);
        taxExcludedRatingAmountValueET = findViewById(R.id.taxExcludedRatingAmountValue);
        taxIncludedRatingAmountUnitET = findViewById(R.id.taxIncludedRatingAmountUnit);
        taxIncludedRatingAmountValueET = findViewById(R.id.taxIncludedRatingAmountValue);
        taxRateET = findViewById(R.id.taxRate);
        usageRatingTagET = findViewById(R.id.usageRatingTag);
        RatedProductUsageBaseTypeET = findViewById(R.id.RatedProductUsageBaseType);
        RatedProductUsageSchemaLocationET = findViewById(R.id.RatedProductUsageSchemaLocation);
        RatedProductUsageTypeET = findViewById(R.id.RatedProductUsageType);

        // Product Reference
        ProductRefIdET = findViewById(R.id.ProductRefId);
        ProductRefHrefET = findViewById(R.id.ProductRefHref);
        ProductRefNameET = findViewById(R.id.ProductRefName);
        ProductRefRelationshipTypeET = findViewById(R.id.ProductRefRelationshipType);
        ProductRefBaseTypeET = findViewById(R.id.ProductRefBaseType);
        ProductRefReferedTypeET = findViewById(R.id.ProductRefReferedType);
        ProductRefSchemaLocationET = findViewById(R.id.ProductRefSchemaLocation);
        ProductRefTypeET = findViewById(R.id.ProductRefType);

        // Related Party
        RelatedPartyIdET = findViewById(R.id.RelatedPartyId);
        RelatedPartyHrefET = findViewById(R.id.RelatedPartyHref);
        RelatedPartyNameET = findViewById(R.id.RelatedPartyName);
        RelatedPartyRoleET = findViewById(R.id.RelatedPartyRole);
        RelatedPartyBaseTypeET = findViewById(R.id.RelatedPartyBaseType);
        RelatedPartyReferedTypeET = findViewById(R.id.RelatedPartyReferedType);
        RelatedPartySchemaLocationET = findViewById(R.id.RelatedPartySchemaLocation);
        RelatedPartyTypeET = findViewById(R.id.RelatedPartyType);

        // Usage Characteristic
        UsageCharacteristicIdET = findViewById(R.id.UsageCharacteristicId);
        UsageCharacteristicNameET = findViewById(R.id.UsageCharacteristicName);
        UsageCharacteristicValueET = findViewById(R.id.UsageCharacteristicValue);
        UsageCharacteristicBaseTypeET = findViewById(R.id.UsageCharacteristicBaseType);
        UsageCharacteristicValueTypeET = findViewById(R.id.UsageCharacteristicValueType);
        UsageCharacteristicSchemaLocationET = findViewById(R.id.UsageCharacteristicSchemaLocation);
        UsageCharacteristicTypeET = findViewById(R.id.UsageCharacteristicType);

        // Characteristic Relationship
        CharacteristicRelationshipIdET = findViewById(R.id.characteristicRelationshipId);
        CharacteristicRelationshipHrefET = findViewById(R.id.characteristicRelationshipHref);
        CharacteristicRelationshipRelationshipTypeET = findViewById(R.id.characteristicRelationshipRelationshipType);
        CharacteristicRelationshipBaseTypeET = findViewById(R.id.characteristicRelationshipBaseType);
        CharacteristicRelationshipSchemaLocationET = findViewById(R.id.characteristicRelationshipSchemaLocation);
        CharacteristicRelationshipTypeET = findViewById(R.id.characteristicRelationshipType);

        // Usage Specification
        UsageSpecificationIdET = findViewById(R.id.usageSpecificationId);
        UsageSpecificationHrefET = findViewById(R.id.usageSpecificationHref);
        UsageSpecificationNameET = findViewById(R.id.usageSpecificationName);
        UsageSpecificationBaseTypeET = findViewById(R.id.usageSpecificationBaseType);
        UsageSpecificationReferedTypeET = findViewById(R.id.usageSpecificationReferedType);
        UsageSpecificationSchemaLocationET = findViewById(R.id.usageSpecificationSchemaLocation);
        UsageSpecificationTypeET = findViewById(R.id.usageSpecificationType);

        //endregion

        usageUsageDateET.setOnClickListener(v -> new DatePickerDialog(context, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show());

        ratingDateET.setOnClickListener(v -> new DatePickerDialog(context, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show());

        usageStatusSP.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, UsageStatusType.values()));

        Bundle b = getIntent().getExtras();

        if(b != null) {
            editKey = b.getString("itemId");
            Log.d(LOG_TAG, editKey);

            queryData();

            Log.d(LOG_TAG, String.valueOf(mEditItem));
        }

    }

    private void queryData() {
        mCollectionReference.document(editKey).get().addOnSuccessListener(documentSnapshot -> {
           mEditItem = documentSnapshot.toObject(Usage.class);
           Log.d(LOG_TAG, mEditItem.getId());
           setDataForEdit(mEditItem);
        });
    }

    DatePickerDialog.OnDateSetListener date = (view, year, monthOfYear, dayOfMonth) -> {
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, monthOfYear);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        updateLabel();
    };

    private void updateLabel() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        usageUsageDateET.setText(sdf.format(myCalendar.getTime()));
    }

    public void submit(View view) {
        setData();

        if(!(editKey == null) && !editKey.equals("")) {
            mUsage.setId(editKey);
            new Update(mFirestore).execute(mUsage);
        } else {
            new Insert(mFirestore).execute(mUsage);
        }
    }


    public static class Update extends AsyncTask<Usage, Void, Void> {
        FirebaseFirestore mFirestore;

        public Update(FirebaseFirestore firestore) {
            this.mFirestore = firestore;
        }

        @Override
        protected Void doInBackground(Usage... usages) {
            mFirestore.collection("usage").document(usages[0].getId()).set(usages[0])
                    .addOnSuccessListener(v -> Log.d("UpdateTask", "data updated successfully"))
                    .addOnFailureListener(v -> Log.d("UpdateTask", "data failed to update"));

            return null;
        }
    }

    public static class Insert extends AsyncTask<Usage, Void, Void> {
        FirebaseFirestore mFirestore;

        public Insert(FirebaseFirestore firestore) {
            this.mFirestore = firestore;
        }

        @Override
        protected Void doInBackground(Usage... usages) {
            mFirestore.collection("usage").add(usages[0])
                    .addOnSuccessListener(v -> Log.d("InsertTask", "data inserted successfully"))
                    .addOnFailureListener(v -> Log.d("InsertTask", "data failed to insert"));

            return null;
        }
    }

    // Create Model
    private void setData(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
        Date ratingDateVar = new Date();
        Date usageDateVar = new Date();
        try {
            ratingDateVar = sdf.parse(ratingDateET.getText().toString());
            usageDateVar = sdf.parse(usageUsageDateET.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        mProductRef = new ProductRef(
                ProductRefIdET.getText().toString(),
                ProductRefHrefET.getText().toString(),
                ProductRefNameET.getText().toString(),
                ProductRefRelationshipTypeET.getText().toString(),
                ProductRefBaseTypeET.getText().toString(),
                ProductRefReferedTypeET.getText().toString(),
                ProductRefSchemaLocationET.getText().toString(),
                ProductRefTypeET.getText().toString()
        );

        int isBilledSelectedId = isBilledRG.getCheckedRadioButtonId();
        int isTaxExemptSelectedId = isTaxExemptRG.getCheckedRadioButtonId();
        RadioButton isBilledRadioButton = (RadioButton) findViewById(isBilledSelectedId);
        RadioButton isTaxExemptRadioButton = (RadioButton) findViewById(isTaxExemptSelectedId);

        Log.d(LOG_TAG, isBilledRadioButton.getText().toString());

        mRatedProductUsage = new RatedProductUsage(
                new Money(bucketValueConvertedInAmountUnitET.getText().toString(), Double.parseDouble(bucketValueConvertedInAmountValueET.getText().toString().isEmpty() ? "0" : bucketValueConvertedInAmountValueET.getText().toString())),
                isBilledRadioButton.getText().toString().equals("Yes"),
                isTaxExemptRadioButton.getText().toString().equals("Yes"),
                offerTariffTypeET.getText().toString(),
                ratingAmountTypeET.getText().toString(),
                ratingDateVar,
                new Money(taxExcludedRatingAmountUnitET.getText().toString(), Double.parseDouble(taxExcludedRatingAmountValueET.getText().toString().isEmpty() ? "0" : taxExcludedRatingAmountValueET.getText().toString())),
                new Money(taxIncludedRatingAmountUnitET.getText().toString(), Double.parseDouble(taxIncludedRatingAmountValueET.getText().toString().isEmpty() ? "0" : taxIncludedRatingAmountValueET.getText().toString())),
                Double.parseDouble(taxRateET.getText().toString().isEmpty() ? "0" : taxRateET.getText().toString()),
                usageRatingTagET.getText().toString(),
                mProductRef,
                RatedProductUsageBaseTypeET.getText().toString(),
                RatedProductUsageSchemaLocationET.getText().toString(),
                RatedProductUsageTypeET.getText().toString()
        );

        mRelatedParty = new RelatedParty(
                RelatedPartyIdET.getText().toString(),
                RelatedPartyHrefET.getText().toString(),
                RelatedPartyNameET.getText().toString(),
                RelatedPartyRoleET.getText().toString(),
                RelatedPartyBaseTypeET.getText().toString(),
                RelatedPartyReferedTypeET.getText().toString(),
                RelatedPartySchemaLocationET.getText().toString(),
                RelatedPartyTypeET.getText().toString()
        );

        mCharacteristicRelationship = new CharacteristicRelationship(
                CharacteristicRelationshipIdET.getText().toString(),
                CharacteristicRelationshipHrefET.getText().toString(),
                CharacteristicRelationshipRelationshipTypeET.getText().toString(),
                CharacteristicRelationshipBaseTypeET.getText().toString(),
                CharacteristicRelationshipSchemaLocationET.getText().toString(),
                CharacteristicRelationshipTypeET.getText().toString()
        );

        mUsageCharacteristic = new UsageCharacteristic(
                UsageCharacteristicIdET.getText().toString(),
                UsageCharacteristicNameET.getText().toString(),
                UsageCharacteristicValueET.getText().toString(),
                UsageSpecificationBaseTypeET.getText().toString(),
                mCharacteristicRelationship,
                UsageCharacteristicValueTypeET.getText().toString(),
                UsageCharacteristicSchemaLocationET.getText().toString(),
                UsageCharacteristicTypeET.getText().toString()
        );

        mUsageSpecificationRef = new UsageSpecificationRef(
                UsageSpecificationIdET.getText().toString(),
                UsageSpecificationHrefET.getText().toString(),
                UsageSpecificationNameET.getText().toString(),
                UsageSpecificationBaseTypeET.getText().toString(),
                UsageSpecificationReferedTypeET.getText().toString(),
                UsageSpecificationSchemaLocationET.getText().toString(),
                UsageSpecificationTypeET.getText().toString()
        );

        mUsage = new Usage(
                usageHrefET.getText().toString(),
                usageDateVar,
                usageTypeET.getText().toString(),
                usageDescriptionET.getText().toString(),
                (UsageStatusType) usageStatusSP.getSelectedItem(),
                usageBaseTypeET.getText().toString(),
                usageSchemaLocationET.getText().toString(),
                usageTypeET.getText().toString(),
                mRatedProductUsage,
                mRelatedParty,
                mUsageCharacteristic,
                mUsageSpecificationRef
        );
    }

    private void setDataForEdit(Usage usage) {

        usageHrefET.setText(usage.getHref());
        usageUsageDateET.setText(usage.getUsageDate().toString());
        usageUsageTypeET.setText(usage.getUsageType());
        usageDescriptionET.setText(usage.getDescription());
        usageStatusSP.setSelection(usage.getStatus().getValue());
        usageBaseTypeET.setText(usage.getBaseType());
        usageSchemaLocationET.setText(usage.getSchemaLocation());
        usageTypeET.setText(usage.getType());

        bucketValueConvertedInAmountValueET.setText(usage.getRatedProductUsage().getBucketValueConvertedInAmount().getValue().toString());
        bucketValueConvertedInAmountUnitET.setText(usage.getRatedProductUsage().getBucketValueConvertedInAmount().getUnit());

        RadioButton isBilledRadioButtonTrue = (RadioButton) findViewById(R.id.isBilledTrue);
        RadioButton isBilledRadioButtonFalse = (RadioButton) findViewById(R.id.isBilledFalse);
        RadioButton isTaxExemptRadioButtonTrue = (RadioButton) findViewById(R.id.isTaxExemptTrue);
        RadioButton isTaxExemptRadioButtonFalse = (RadioButton) findViewById(R.id.isTaxExemptFalse);

        if(usage.getRatedProductUsage().getBilled())
            isBilledRadioButtonTrue.setChecked(true);
        else
            isBilledRadioButtonFalse.setChecked(true);

        if(usage.getRatedProductUsage().getTaxExempt())
            isTaxExemptRadioButtonTrue.setChecked(true);
        else
            isTaxExemptRadioButtonFalse.setChecked(true);

        offerTariffTypeET.setText(usage.getRatedProductUsage().getOfferTariffType());
        ratingAmountTypeET.setText(usage.getRatedProductUsage().getRatingAmountType());
        ratingDateET.setText(usage.getRatedProductUsage().getRatingDate() == null ? "" : usage.getRatedProductUsage().getRatingDate().toString());
        taxExcludedRatingAmountValueET.setText(usage.getRatedProductUsage().getTaxExcludedRatingAmount().getValue().toString());
        taxExcludedRatingAmountUnitET.setText(usage.getRatedProductUsage().getTaxExcludedRatingAmount().getUnit());
        taxIncludedRatingAmountValueET.setText(usage.getRatedProductUsage().getTaxIncludedRatingAmount().getValue().toString());
        taxIncludedRatingAmountUnitET.setText(usage.getRatedProductUsage().getTaxIncludedRatingAmount().getUnit());
        taxRateET.setText(usage.getRatedProductUsage().getTaxRate() == null ? "" : usage.getRatedProductUsage().getTaxRate().toString());
        usageRatingTagET.setText(usage.getRatedProductUsage().getUsageRatingTag());
        RatedProductUsageBaseTypeET.setText(usage.getRatedProductUsage().getBaseType());
        RatedProductUsageSchemaLocationET.setText(usage.getRatedProductUsage().getSchemaLocation());
        RatedProductUsageTypeET.setText(usage.getRatedProductUsage().getType());

        ProductRefIdET.setText(usage.getRatedProductUsage().getProductRef().getId());
        ProductRefHrefET.setText(usage.getRatedProductUsage().getProductRef().getHref());
        ProductRefNameET.setText(usage.getRatedProductUsage().getProductRef().getName());
        ProductRefRelationshipTypeET.setText(usage.getRatedProductUsage().getProductRef().getRelationshipType());
        ProductRefBaseTypeET.setText(usage.getRatedProductUsage().getProductRef().getBaseType());
        ProductRefReferedTypeET.setText(usage.getRatedProductUsage().getProductRef().getReferedType());
        ProductRefSchemaLocationET.setText(usage.getRatedProductUsage().getProductRef().getSchemaLocation());
        ProductRefTypeET.setText(usage.getRatedProductUsage().getProductRef().getType());

        RelatedPartyIdET.setText(usage.getRelatedParty().getId());
        RelatedPartyHrefET.setText(usage.getRelatedParty().getHref());
        RelatedPartyNameET.setText(usage.getRelatedParty().getName());
        RelatedPartyRoleET.setText(usage.getRelatedParty().getRole());
        RelatedPartyBaseTypeET.setText(usage.getRelatedParty().getBaseType());
        RelatedPartyReferedTypeET.setText(usage.getRelatedParty().getReferedType());
        RelatedPartySchemaLocationET.setText(usage.getRelatedParty().getSchemaLocation());
        RelatedPartyTypeET.setText(usage.getRelatedParty().getType());

        UsageCharacteristicIdET.setText(usage.getUsageCharacteristic().getId());
        UsageCharacteristicNameET.setText(usage.getUsageCharacteristic().getName());
        UsageCharacteristicValueET.setText(usage.getUsageCharacteristic().getValue());
        UsageCharacteristicBaseTypeET.setText(usage.getUsageCharacteristic().getBaseType());
        UsageCharacteristicValueTypeET.setText(usage.getUsageCharacteristic().getValueType());
        UsageCharacteristicSchemaLocationET.setText(usage.getUsageCharacteristic().getSchemaLocation());
        UsageCharacteristicTypeET.setText(usage.getUsageCharacteristic().getType());

        CharacteristicRelationshipIdET.setText(usage.getUsageCharacteristic().getCharacteristicRelationship().getId());
        CharacteristicRelationshipHrefET.setText(usage.getUsageCharacteristic().getCharacteristicRelationship().getHref());
        CharacteristicRelationshipRelationshipTypeET.setText(usage.getUsageCharacteristic().getCharacteristicRelationship().getRelationshipType());
        CharacteristicRelationshipBaseTypeET.setText(usage.getUsageCharacteristic().getCharacteristicRelationship().getType());
        CharacteristicRelationshipSchemaLocationET.setText(usage.getUsageCharacteristic().getCharacteristicRelationship().getSchemaLocation());
        CharacteristicRelationshipTypeET.setText(usage.getUsageCharacteristic().getCharacteristicRelationship().getType());

        UsageSpecificationIdET.setText(usage.getUsageSpecification().getId());
        UsageSpecificationHrefET.setText(usage.getUsageSpecification().getHref());
        UsageSpecificationNameET.setText(usage.getUsageSpecification().getName());
        UsageSpecificationBaseTypeET.setText(usage.getUsageSpecification().getBaseType());
        UsageSpecificationReferedTypeET.setText(usage.getUsageSpecification().getReferedType());
        UsageSpecificationSchemaLocationET.setText(usage.getUsageSpecification().getSchemaLocation());
        UsageSpecificationTypeET.setText(usage.getUsageSpecification().getType());
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}