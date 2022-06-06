package ma.soumih.ebankingbackend.security.services;

import ma.soumih.ebankingbackend.exceptions.AppRoleAlreadyExistsException;
import ma.soumih.ebankingbackend.exceptions.AppRoleNotFoundException;
import ma.soumih.ebankingbackend.exceptions.EmployeeNotFoundException;
import ma.soumih.ebankingbackend.dtos.EmployeeDTO;
import ma.soumih.ebankingbackend.dtos.InEmployeeDTO;
import ma.soumih.ebankingbackend.security.entities.AppRole;
import ma.soumih.ebankingbackend.security.entities.AppUser;

public interface AppUserService {

    EmployeeDTO saveNewEmployee(InEmployeeDTO inEmployeeDTO) throws AppRoleNotFoundException, EmployeeNotFoundException;

    AppRole saveNewRole(String roleName, String description) throws AppRoleAlreadyExistsException;
    void addRoleToUser(String username, String roleName) throws EmployeeNotFoundException, AppRoleNotFoundException;
    void removeRoleFromUser(String username, String roleName) throws EmployeeNotFoundException, AppRoleNotFoundException;
    AppUser loadUserByUsername(String username);
}
