import * as React from "react";

export const Select = ({ name, value, options, onChange }) => {
    return (
        <select name={name} value={value} onChange={onChange}>
            {options.map((option) => (
                <option value={option.value}>{option.label}</option>
            ))}
        </select>
    );
};

export const SelectCourse = ({ name, value, options, onChange }) => {
    return (
        <select name={name} value={value} onChange={onChange}>
            {options.map((option) => (
                <option value={option.id}>{option.name}</option>
            ))}
        </select>
    );
};

export const SelectStudent = ({ name, value, options, onChange }) => {
    return (
        <select name={name} value={value} onChange={onChange}>
            {options.map((option) => (
                <option value={option.id}>{option.firstName} {option.familyName}</option>
            ))}
        </select>
    );
};
