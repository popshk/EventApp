<div id="registrationModal" class="modal">
    <div class="modal-content">
        <h2>Registration form</h2>
        <form class="rf" method="post" action="/registration">
            <input class="form-control me-2 flex-grow-1" type="text" name="username" id="username" placeholder="Username">
            <input class="form-control me-2 flex-grow-1" type="text" name="email" id="email" placeholder="E-mail">
            <input class="form-control me-2 flex-grow-1" type="password" name="password" id="password"
                   placeholder="Password">
            <input class="form-control me-2 flex-grow-1" type="password" name="confirm-password" id="confirm-password"
                   placeholder="Confirm password">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button class="btn btn-success custom-btn-width-2" type="submit">Submit</button>
        </form>
    </div>
</div>
<script>
    var modal = document.getElementById("registrationModal");
    var btn = document.getElementById("openModalButton");
    btn.onclick = function() {
        modal.style.display = "block";
    }
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>