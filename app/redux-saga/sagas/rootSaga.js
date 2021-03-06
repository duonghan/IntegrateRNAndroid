import {call, fork} from 'redux-saga/effects';
//Add movie
import {watchAddNewMovie, watchFetchMovies} from './movieSagas';

export default function* rootSaga() {
    yield [
        call(watchFetchMovies),
        fork(watchAddNewMovie)
    ];

}