import React, {useState} from 'react';
import './App.css';
import {BrowserRouter, Navigate, Route, Routes} from "react-router-dom";
import LoginPage from "./pages/LoginPage";
import PrivateRoute from "./provider/PrivateRoute";
import FeedPage from "./pages/FeedPage";
import UploadPage from "./pages/UploadPage";
import SignupPage from "./pages/SignupPage";
import StoryUploadPage from "./pages/StoryUploadPage";
import MyFeedPage from "./pages/MyFeedPage";
import StoryDetail from "./pages/StoryDetail";
import EditProfilePage from "./pages/EditProfilePage";
import KakaoCallback from "./pages/KakaoCallback";
import PostDetailPage from "./pages/PostDetailPage";
import FeedDetail from "./components/FeedDetail";

function App() {

    // localStorage에서 user를 안전하게 불러오기
    const [user, setUser] = useState(() => {
        try {
            const savedUser = localStorage.getItem("user");
            const token = localStorage.getItem("token");

            if (savedUser && savedUser !== "undefined" && token) {
                try {
                    return JSON.parse(savedUser);
                } catch (err) {
                    console.error("user JSON parse error", err);
                    localStorage.removeItem("user"); // 잘못된 데이터 제거
                }
            }
            return null;
        } catch (err) {
            localStorage.removeItem("user");
            localStorage.removeItem("token");
            return null;
        }
    });

    return (
        <div>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Navigate to="/login" replace/>}/>
                    <Route path="/login" element={<LoginPage/>}/>
                    <Route path="/auth/kakao/callback" element={<KakaoCallback/>}/>
                    <Route path="/signup" element={<SignupPage/>}/>

                    <Route path="/feed"
                           element={
                               <PrivateRoute>
                                   <FeedPage/>
                               </PrivateRoute>}
                    />
                    <Route
                        path="/post/:postId"
                        element={
                            <PostDetailPage/>
                        }
                    />
                    <Route
                        path="/story/detail/:userId"
                        element={
                            <PrivateRoute>
                                <StoryDetail/>
                            </PrivateRoute>}
                    />
                    <Route path="/upload"
                           element={
                               <PrivateRoute>
                                   <UploadPage/>
                               </PrivateRoute>
                           }
                    />
                    <Route
                        path="/story/upload"
                        element={
                            <PrivateRoute>
                                <StoryUploadPage/>
                            </PrivateRoute>}
                    />

                    <Route
                        path="/myfeed"
                        element={
                            <PrivateRoute>
                                <MyFeedPage/>
                            </PrivateRoute>}
                    />
                    <Route
                        path="/myfeed/:userId"
                        element={
                            <PrivateRoute>
                                <FeedDetail/>
                            </PrivateRoute>}
                    />
                    <Route
                        path="/profile/edit"
                        element={
                            <PrivateRoute>
                                <EditProfilePage/>
                            </PrivateRoute>}
                    />
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
