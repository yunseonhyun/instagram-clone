import React from 'react';
import {Navigate} from "react-router-dom";

const PrivateRoute = ({ children }) => {
    // TODO: localStorage에서 token을 가져오세요
    const token = localStorage.getItem('token');
    // TODO: token이 없으면 /login으로 리다이렉트 하세요
    if(!token) return <Navigate to="/login" replace/>
    // TODO: token이 있으면 children을 반환하세요
    return children;
};

export default PrivateRoute;