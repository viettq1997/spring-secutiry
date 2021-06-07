## 07/06/2021
    - @PreAuthorize("hasAuthority('student:write')")
    - .csrf().disable() -> disable. nếu không disable thì hacker có thể dùng csrf token để call post, put, delete
    - csrf token in cookies
    - .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) -> to see : how to generate csrf token