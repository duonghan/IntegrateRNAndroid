import {ADD_MOVIE, FETCH_FAILED, FETCH_MOVIES, FETCH_SUCCEEDED} from '../actions/actionTypes';
//Saga effects
import {put, takeLatest} from 'redux-saga/effects';
import {Api} from './Api';

function* fetchMovies() {
    try {
        debugger;
        const receivedMovies = yield Api.getMoviesFromApi();

        yield put({type: FETCH_SUCCEEDED, receivedMovies: receivedMovies});
        debugger;
    } catch (error) {
        yield put({type: FETCH_FAILED, error});
    }
}

export function* watchFetchMovies() {
    yield takeLatest(FETCH_MOVIES, fetchMovies);
}

//Add new movie
function* addNewMovie(action) {
    try {
        const result = yield Api.insertNewMovieFromApi(action.newMovie);
        if (result === true) {
            yield put({type: FETCH_MOVIES, sort: 'desc'});
        }
    } catch (error) {
        //do nothing
    }
}

export function* watchAddNewMovie() {
    yield takeLatest(ADD_MOVIE, addNewMovie);
}