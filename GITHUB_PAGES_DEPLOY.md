# Deploy to GitHub Pages

## Quick Deployment Steps

### 1. Install gh-pages Package

```cmd
cd frontend
npm install --save-dev gh-pages
```

### 2. Deploy to GitHub Pages

```cmd
npm run deploy
```

This will build and deploy your frontend to GitHub Pages.

### 3. Enable GitHub Pages

1. Go to https://github.com/Stark6612/JAVA/settings/pages
2. Under **Source**, select:
   - Branch: `gh-pages`
   - Folder: `/ (root)`
3. Click **Save**

### 4. Access Your Site

Your site will be live at: **https://Stark6612.github.io/JAVA**

---

## Running the Full Application

### Start Backend (Required for Login/Register to work)

```cmd
cd backend
mvn spring-boot:run
```

Backend runs on: http://localhost:8080

### Start Frontend Locally (Optional - for development)

```cmd
cd frontend
npm start
```

Frontend runs on: http://localhost:3000

---

## Important Notes

⚠️ **Backend Must Be Running Locally**

Since the backend runs on `localhost:8080`, the deployed GitHub Pages site will only work when:
1. You're accessing it from the same computer where the backend is running
2. The backend is actively running (`mvn spring-boot:run`)

For others to use your site, you would need to deploy the backend to a cloud service (Railway, Render, Heroku, etc.)

---

## Configuration Summary

✅ **Frontend URL:** https://Stark6612.github.io/JAVA
✅ **Backend URL:** http://localhost:8080
✅ **Homepage:** Configured in `package.json`
✅ **CORS:** Configured for GitHub Pages
✅ **Deploy Scripts:** Added to `package.json`

---

## Redeploy After Changes

```cmd
cd frontend
npm run deploy
```

---

## Troubleshooting

### Site shows 404
- Wait 2-3 minutes after first deployment
- Check GitHub Pages settings
- Verify `gh-pages` branch exists

### Login/Register doesn't work
- Ensure backend is running: `mvn spring-boot:run`
- Check browser console for errors
- Verify backend is on port 8080

### CORS errors
- Already configured for `https://stark6612.github.io`
- Restart backend if you made changes

---

## Files Configured

- ✅ `frontend/package.json` - homepage and deploy scripts
- ✅ `frontend/.env.production` - backend URL
- ✅ `backend/.../SecurityConfig.java` - CORS for GitHub Pages
