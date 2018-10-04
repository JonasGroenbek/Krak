package Facade;

import DTO.AddressDTO;
import DTO.CityDTO;
import DTO.HobbyDTO;
import DTO.PersonDTO;
import DTO.PhoneDTO;
import Entities.Address;
import Entities.Cityinfo;
import Entities.Hobby;
import Entities.Person;
import Entities.Phone;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;

public class EntityToJSON {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    //ADDRESSES JSONCONVERTERS
    public String getJSONfromAddress(Address address) {
        return gson.toJson(new AddressDTO(address));
    }

    public String getAddressFromJson(String json) {
        return null;
    }

    public String getJsonFromAddresses(List<Address> addresses) {
        List<AddressDTO> addressDTOList = new ArrayList();
        for (Address address : addresses) {
            addressDTOList.add(new AddressDTO(address));
        }
        return gson.toJson(addressDTOList);
    }

    public String getJsonFromAddressDTO(AddressDTO addressDTO) {
        return gson.toJson(addressDTO);
    }

    //CITYINFOS JSONCONVERTERS
    public String getJsonFromCityinfo(Cityinfo cityinfo) {
        return gson.toJson(cityinfo);
    }

    public String getCityinfoFromJson(String json) {
        return gson.toJson(json);
    }

    public String getJsonFromCityinfos(List<Cityinfo> cityinfos) {
        return gson.toJson(cityinfos);
    }

    public String getJsonFromCityDTO(CityDTO cityDTO) {
        return gson.toJson(cityDTO);
    }

    //HOBBIES JSONCONVERTERS
    public String getJsonFromHobby(Hobby hobby) {
        return gson.toJson(hobby);

    }

    public String getHobbyFromJson(String json) {
        return gson.toJson(json);
    }

    public String getJsonFromHobbies(List<Hobby> hobbies) {
        return gson.toJson(hobbies);
    }

    public String getJsonFromHobbyDTO(HobbyDTO hobbyDTO) {
        return gson.toJson(hobbyDTO);
    }

    //PERSONS JSONCONVERTERS
    public String getJsonFromPerson(Person person) {
        return gson.toJson(person);

    }

    public String getPersonFromJson(String json) {
        return gson.toJson(json);
    }

    public String getJsonFromPersons(List<Person> persons) {
        return gson.toJson(persons);
    }

    public String getJsonFromPersonDTO(PersonDTO personDTO) {
        return gson.toJson(personDTO);
    }

    //PHONES JSONCONVERTERS
    public String getJsonFromPhone(Phone phone) {
        return gson.toJson(phone);

    }

    public String getPhoneFromJson(String json) {
        return gson.toJson(json);
    }

    public String getJsonFromPhones(List<Phone> phones) {
        return gson.toJson(phones);
    }

    public String getJsonFromPhoneDTO(PhoneDTO phoneDTO) {
        return gson.toJson(phoneDTO);
    }

}
