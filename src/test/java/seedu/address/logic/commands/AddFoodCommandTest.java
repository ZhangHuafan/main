package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyCalendar;
import seedu.address.model.ReadOnlyUserList;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.bio.User;
import seedu.address.model.calendar.CalendarEntry;
import seedu.address.model.person.Person;
import seedu.address.model.record.Record;
import seedu.address.model.record.UniqueRecordList;
import seedu.address.testutil.FoodBuilder;
import seedu.sgm.model.food.Food;
import seedu.sgm.model.food.UniqueFoodList;

class AddFoodCommandTest {

    private Food food;

    @Test
    public void constructor_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddFoodCommand(null));
    }

    @Test
    public void execute_foodAcceptedByModel_addSuccessful() throws Exception {
        AddFoodCommandTest.ModelStubAcceptingFoodAdded modelStub = new AddFoodCommandTest.ModelStubAcceptingFoodAdded();
        Food food = new FoodBuilder().build();

        CommandResult commandResult = new AddFoodCommand(food).execute(modelStub);

        assertEquals(String.format(AddFoodCommand.MESSAGE_SUCCESS, food), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(food), modelStub.foodsAdded);
    }

    @Test
    public void execute_duplicateFood_throwsCommandException() {
        Food validFood = new FoodBuilder().build();
        AddFoodCommand addFoodCommand = new AddFoodCommand(validFood);
        AddFoodCommandTest.ModelStub modelStub = new AddFoodCommandTest.ModelStubWithFood(validFood);

        assertThrows(CommandException.class, AddFoodCommand.MESSAGE_DUPLICATE_FOOD, () ->
            addFoodCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Food yogurt = new FoodBuilder().withFoodName("Yogurt").build();
        Food water = new FoodBuilder().withFoodName("water").build();
        AddFoodCommand addYogurtCommand = new AddFoodCommand(yogurt);
        AddFoodCommand addWaterCommand = new AddFoodCommand(water);

        // same object -> returns true
        assertTrue(addYogurtCommand.equals(addYogurtCommand));

        // same values -> returns true
        AddFoodCommand addFoodCommandCopy = new AddFoodCommand(yogurt);
        assertTrue(addYogurtCommand.equals(addFoodCommandCopy));

        // different types -> returns false
        assertFalse(addYogurtCommand.equals(1));

        // null -> returns false
        assertFalse(addYogurtCommand.equals(null));

        // different food -> returns false
        assertFalse(addYogurtCommand.equals(addWaterCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePerson(Person target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Person target, Person editedPerson) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Person> getFilteredPersonList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPersonList(Predicate<Person> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addRecord(Record toAdd) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public UniqueRecordList getUniqueRecordListObject() {
            return null;
        }

        @Override
        public ObservableList<Record> getRecordList() {
            return null;
        }

        @Override
        public ObservableList<Record> getFilterRecordList() {
            return null;
        }

        @Override
        public boolean hasRecord(Record toAdd) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteRecord(Record record) {

        }

        @Override
        public void updateFilteredRecordList(Predicate<Record> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasFood(Food food) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addFood(Food food) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteFood(Food food) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public UniqueFoodList getUniqueFoodListObject() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Food> getFoodList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setFoodList(UniqueFoodList newFoodList) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Food> getFilterFoodList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredFoodList(Predicate<Food> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setRecordList(UniqueRecordList newRecordList) {

        }

        //=========== User List =============================================================
        @Override
        public void setUserList(ReadOnlyUserList userList) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean bioExists() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserList getUserList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getUserListFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasUser(User user) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addUser(User user) {
            throw new AssertionError("This method should not be called.");

        }

        @Override
        public ObservableList<User> getFilteredUserList() {
            throw new AssertionError("This method should not be called.");

        }

        @Override
        public void updateFilteredUserList(Predicate<User> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyCalendar getCalendar() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasCalendarEntry(CalendarEntry calendarEntry) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteCalendarEntry(CalendarEntry target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addCalendarEntry(CalendarEntry calendarEntry) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setCalendarEntry(CalendarEntry target, CalendarEntry editedCalendarEntry) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<CalendarEntry> getFilteredCalendarEntryList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setUser(User target, User editedUser) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setUserListFilePath(Path userListFilePath) {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single food.
     */
    private class ModelStubWithFood extends AddFoodCommandTest.ModelStub {
        private final Food food;

        ModelStubWithFood(Food food) {
            requireNonNull(food);
            this.food = food;
        }

        @Override
        public boolean hasFood(Food food) {
            requireNonNull(food);
            return this.food.isSameFood(food);
        }
    }

    /**
     * A Model stub that always accept the food being added.
     */
    private class ModelStubAcceptingFoodAdded extends AddFoodCommandTest.ModelStub {
        final ArrayList<Food> foodsAdded = new ArrayList<>();

        @Override
        public boolean hasFood(Food food) {
            requireNonNull(food);
            return foodsAdded.stream().anyMatch(food::isSameFood);
        }

        @Override
        public void addFood(Food food) {
            requireNonNull(food);
            foodsAdded.add(food);
        }

    }
}