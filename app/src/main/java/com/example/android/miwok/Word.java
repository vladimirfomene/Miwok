package com.example.android.miwok;

/**
 * File: Word.java
 * =================================================
 * Represents a particular word in the miwok language and it translation in any other language.
 * Created by vladimirfomene on 12/20/16.
 */

public class Word {

    //stores the state of the default language word
    private String mDefaultTranslation;


    //stores the state of the miwok version of the word
    private String mMiwokTranslation;

    //Image resource Id for a word
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    //Stores the state of no image
    private static final int NO_IMAGE_PROVIDED = -1;

    //audio resource Id for a word
    private int mAudioResourceId = NO_AUDIO_PROVIDED;


    //Stores the state of no image
    private static final int NO_AUDIO_PROVIDED = -1;

    /**
     * create a word from its default version and its miwok translation
     * @param miwokWord version of the word
     * @param defaultWord version of the word
     */
    public Word(String miwokWord, String defaultWord, int audioID){
        mDefaultTranslation = defaultWord;
        mMiwokTranslation = miwokWord;
        mAudioResourceId = audioID;
    }

    /**
     * create a word from its default version and its miwok translation
     * @param miwokWord version of word
     * @param defaultWord version of word
     * @param imageID image resource id.
     */
    public Word(String miwokWord, String defaultWord, int imageID, int audioID){
        mDefaultTranslation = defaultWord;
        mMiwokTranslation = miwokWord;
        mImageResourceId = imageID;
        mAudioResourceId = audioID;
    }



    /**
     * Gets the miwok translation of a particular word
     * @return miwok translation of a word
     */
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    /**
     * Gets the default translation of a particular word
     * @return default version of the word
     */
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    /**
     * Gets the image resource Id for a particular word.
     * @return mImageResourceId
     */
    public int getmImageResourceId(){
        return mImageResourceId;
    }

    /**
     * Check whether a word has an image or whether it doesn't.
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }


    /**
     * Gets the audio resource id for a particular word
     * @return mAudioResourceId
     */
    public int getmAudioResourceId(){ return mAudioResourceId; }


    /**
     * Check whether a word has an audio or whether it doesn't.
     */
    public boolean hasAudio(){
        return mAudioResourceId != NO_IMAGE_PROVIDED;
    }



    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }

}
